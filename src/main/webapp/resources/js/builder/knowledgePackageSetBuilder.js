import {knowledgePackageRestApi} from "/resources/js/rest/knowledgePackageRestApi.js";
import {knowledgePackageSetRestApi} from "/resources/js/rest/knowledgePackageSetRestApi.js";

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
		}
	],
	autoWidth: true
});

async function build() {
	const url = window.location.pathname;
	const id = url.substring(url.lastIndexOf('/') + 1);

	const knowledgePackageSet = await knowledgePackageSetRestApi.getById(id);

	grid.data.parse(knowledgePackageSet.knowledgePackages);
}

document.addEventListener("DOMContentLoaded", async () => build())
