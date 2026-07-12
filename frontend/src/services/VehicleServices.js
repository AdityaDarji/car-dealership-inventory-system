import api from "../api/axiosConfig";

export const getAllVehicles = () => api.get("/api/vehicle");

export const getVehicleById = (id) => api.get(`/api/vehicle/${id}`);

export const addVehicle = (vehicle) => api.post("/api/vehicle", vehicle);

export const updateVehicle = (id, vehicle) =>
  api.put(`/api/vehicle/${id}`, vehicle);

export const deleteVehicle = (id) => api.delete(`/api/vehicle/${id}`);

export const purchaseVehicle = (id) => api.post(`/api/vehicle/${id}/purchase`);

export const restockVehicle = (id, quantity) =>
  api.post(`/api/vehicle/${id}/restock`, {
    quantity,
  });

export const searchVehicle = (params) =>
  api.get("/api/vehicle/search", {
    params,
  });
