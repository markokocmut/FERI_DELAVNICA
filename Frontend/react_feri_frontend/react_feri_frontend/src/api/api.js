import axios from 'axios';

export const employemntMSApi = axios.create({
    baseURL: process.env.REACT_APP_BACKEND_URL,
    timeout: 5000,
    headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
    },
});

export class EmploymentsApi {
    constructor() {
        this.client = axios.create({
            baseURL: process.env.REACT_APP_BACKEND_URL,
            timeout: 5000,
            headers: {
                "Content-Type": "application/json",
                Accept: "application/json",
            },
        });
    }
    //Employe salary change
    getHistory = () => {
        return this.client.get("/history");
    }
    postEmploymentSalary = (id, salaryFactor, employed) => {
        return this.client.post("/employe_salary", {
            id: id,
            salaryFactor: salaryFactor,
            employed : employed
        });
    }
    //employess
    getEmployess = () => {
        return this.client.get("/employess");
    }
    getEmployeById = (id) => {
        return this.client.get(`/employe/${id}`);
    }
    postEmploye = (firstName, lastName, taxCode, position, salaryFactor, salary, employed) => {
        return this.client.post("/employe", {
            firstName: firstName,
            lastName: lastName,
            taxCode: taxCode,
            position : position,
            salaryFactor:salaryFactor,
            salary:salary,
            employed:employed
        });
    }
    putEmploye = (firstName, lastName, taxCode, position, salaryFactor, salary, employed) => {
        return this.client.put(`/employe/${id}`, {
            firstName: firstName,
            lastName: lastName,
            taxCode: taxCode,
            position : position,
            salaryFactor:salaryFactor,
            salary:salary,
            employed:employed
        });
    }
    deleteEmploye = (id) => {
        return this.client.delete(`/employe/${id}`);
    }
}
