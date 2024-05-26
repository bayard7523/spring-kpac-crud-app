import {knowledgePackageRestApi} from "/resources/js/rest/knowledgePackageRestApi.js";

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
			type: "textarea",
			label: "Description",
			name: "description",
			placeholder: "Enter the description",
			validation: function (value) {
				return value && value.length <= 2000;
			},
			errorMessage: "Too short",
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
			width: 400,
			header: [{text: "Title"}, {content: "comboFilter", filterConfig: {multiselection: true}}],
			editable: false,
			sortable: true,
			type: "string",
			resizable: true
		},
		{
			id: "description",
			header: [{text: "Description"}, {content: "inputFilter"}],
			editable: false,
			sortable: true,
			type: "string",
			editorType: "combobox",
			resizable: true
		},
		{
			id: "createdAt",
			width: 150,
			header: [{text: "Creation Date"}, {content: "comboFilter"}],
			sortable: true,
			editable: false,
			type: "date",
			format: "%d-%m-%Y"
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

		knowledgePackageRestApi.deleteById(id).then(() => {
			grid.data.remove(id);
		}).catch(err => {
			console.log(err)
			alert("Failed to delete K-Pac!")
		});
	}
});

form.getItem("submitBtn").events.on("click", (e) => {
	if (!form.validate()) {
		alert("Please fill out the form!");
		return;
	}

	const formData = form.getValue();

	knowledgePackageRestApi.create(formData).then((newId) => {
		knowledgePackageRestApi.getById(newId).then(knowledgePackage => {
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

layout.getCell("form").attach(form);
layout.getCell("grid").attach(grid);

async function build() {
	const knowledgePackages = await knowledgePackageRestApi.getAll();

	grid.data.parse(knowledgePackages);
}


document.addEventListener("DOMContentLoaded", async () => build())
