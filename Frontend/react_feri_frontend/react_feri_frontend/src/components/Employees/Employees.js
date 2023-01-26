import { Button, CircularProgress } from '@mui/material';
import React, { useEffect, useState } from 'react';
import { EmploymentsApi } from '../../api/api';
import AddEmploye from './AddEmploye';
import EditEmploye from './EditEmploye';
import EmployeesTable from './EmployeesTable';

const Employees = () => {
    const [employees, setEmployees] = useState([]);
    const [open, setOpen] = useState(false);
    const [editOpen, setEditOpen] = useState(false);
    const [editId, setEditId] = useState("");
    const [loaded, setLoaded] = useState(false);
    const employmentsApi = new EmploymentsApi();

    const fetchData = () => {
        employmentsApi.getEmployess()
            .then((result) => { setEmployees(result.data); setLoaded(true); })
            .catch((response) => console.log(`error ${response}`));
    }
    useEffect(() => {
        fetchData();

    }, []);
    const handleOpen = () => {
        setOpen(true);
    }
    const handleClose = () => {
        setOpen(false);
        setEditOpen(false);
        setEditId("");
        fetchData();
    }
    const deleteEmploye = async (id) => {
        await employmentsApi.deleteEmploye(id);
        fetchData();
    }
    const editEmploye = (id) => {
        setEditId(id);
        setEditOpen(true);
    }
    return (
        <div style={{ padding: '25px' }}>
            <h2>Employees</h2>
            <Button variant="contained" onClick={handleOpen}>New Employe</Button>
            <br />
            <br />
            {loaded ? <EmployeesTable employees={employees} deleteEmploye={deleteEmploye} editEmploye={editEmploye} /> : <CircularProgress />}
            <AddEmploye open={open} handleClose={handleClose} />
            <EditEmploye open={editOpen} handleClose={handleClose} id={editId} />
        </div>
    );
}

export default Employees;