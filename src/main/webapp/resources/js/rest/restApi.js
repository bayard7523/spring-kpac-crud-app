const API_URL = "http://localhost:8080/api";

export const apiRequest = async (url, options) => {
	return fetch(`${API_URL}${url}`, options)
		.then(response => {
			if (!response.ok) {
				throw new Error(`HTTP error! status: ${response.status}, options: ${JSON.stringify(options)}`);
			}

			return response.json().catch(err => console.error("Failed to parse: " + err));
		})
}
