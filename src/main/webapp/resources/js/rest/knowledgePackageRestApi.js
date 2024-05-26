import {apiRequest} from "/resources/js/rest/restApi.js";

const API_ENDPOINT = "/kpacs";

const getAll = async () => {
	return apiRequest(`${API_ENDPOINT}/all`, {
		method: "GET",
		cache: "no-cache",
	});
}

const getById = async (id) => {
	return apiRequest(`${API_ENDPOINT}/${id}`, {
		method: "GET",
		cache: "no-cache",
	})
}

const create = async (knowledgePackage) => {
	return apiRequest(`${API_ENDPOINT}`, {
		method: "POST",
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(knowledgePackage),
	});
}

const deleteById = async (id) => {
	return apiRequest(`${API_ENDPOINT}/${id}`, {
		method: "DELETE",
	});
}

export const knowledgePackageRestApi = {
	getAll,
	create,
	deleteById,
	getById
};

