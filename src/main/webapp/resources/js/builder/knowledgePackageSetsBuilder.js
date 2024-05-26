import {knowledgePackageRestApi} from "/resources/js/rest/knowledgePackageRestApi.js";
import {knowledgePackageSetRestApi} from "/resources/js/rest/knowledgePackageSetRestApi.js";

const layout = new dhx.Layout("layout_container", {
	type: "space",
	rows: [
		{
			id: "form",
			height: "auto"
		},
		{
			id: "grid",
		}
	]
})

const form = new dhx.Form(null, {
	rows: [
		{
			type: "input",
			label: "Title",
			name: "title",
			placeholder: "Enter the title",
			validation: function (value) {
				return value && value.length <= 250;
			},
			errorMessage: "Too short",
		},
		{
			type: "combo",
			height: 60,
			label: "Choose K-PACs",
			name: "knowledgePackages",
			multiselection: true,
		},
		{
			type: "button",
			text: "Add",
			size: "medium",
			view: "flat",
			submit: true,
			color: "primary",
			id: "submitBtn"
		}
	]
});

form.getItem("submitBtn").events.on("click", (e) => {
	if (!form.validate()) {
		alert("Please fill out the form!");
		return;
	}

	const formData = form.getValue();

	knowledgePackageSetRestApi.create(formData).then((newId) => {
		knowledgePackageSetRestApi.getById(newId).then(knowledgePackage => {
			grid.data.add({
				id: knowledgePackage.id,
				title: knowledgePackage.title,
				description: knowledgePackage.description,
				createdAt: knowledgePackage.createdAt,
			});

			form.clear();
			alert("New K-Pac successfully added!")
		}).catch(err => {
			console.error(err)
			alert("Failed to get K-Pac!");
		});

	}).catch(err => {
		console.error(err)
		alert("Failed to save K-Pac!");
	});
})

const grid = new dhx.Grid("grid_container", {
	columns: [
		{
			id: "id",
			width: 80,
			header: [{text: "ID"}, {content: "comboFilter", filterConfig: {multiselection: true}}],
			editorType: "select",
			editable: false,
			sortable: true,
			type: "number"
		},
		{
			id: "title",
			header: [{text: "Title"}, {content: "comboFilter", filterConfig: {multiselection: true}}],
			editable: false,
			sortable: true,
			type: "string",
			resizable: true
		},
		{
			width: 50,
			id: "delete",
			header: ["&nbsp;"],
			htmlEnable: true,
			tooltip: false,
			sortable: false,
			template: function (cellValue, row, col) {
				return `<span class="fa fa-close btn--remove"></span>`;
			}
		},
	],
	autoWidth: true
});

grid.events.on("cellClick", async (row, col, e) => {
	if (e.target.classList.contains("btn--remove")) {
		const id = row.id;

		knowledgePackageSetRestApi.deleteById(id).then(() => {
			grid.data.remove(id);
		}).catch(err => {
			console.log(err)
			alert("Failed to delete K-Pac!")
		});
	}
});

grid.events.on("cellDblClick", async (row, col, e) => {
	window.open(`/set/${row.id}`);
})

function knowledgePackagesToOptions(knowledgePackages) {
	return knowledgePackages.map(knowledgePackage => {
		return {value: knowledgePackage.title, id: knowledgePackage.id};
	});
}

async function build() {
	const knowledgePackageSet = await knowledgePackageSetRestApi.getAll();

	grid.data.parse(knowledgePackageSet);

	const knowledgePackages = await knowledgePackageRestApi.getAll();

	form.getItem("knowledgePackages").getWidget().data.parse(knowledgePackagesToOptions(knowledgePackages))

	layout.getCell("form").attach(form);
	layout.getCell("grid").attach(grid);
}

document.addEventListener("DOMContentLoaded", async () => build())
