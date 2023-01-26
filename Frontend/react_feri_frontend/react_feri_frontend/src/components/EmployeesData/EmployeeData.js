import { Button, CircularProgress } from '@mui/material';
import React, { useEffect, useState } from 'react';
import { EmploymentsApi } from '../../api/api';
import AddEmployeeData from './AddEmployeeData';
import EmployeeDataTable from './EmployeeDataTable';

const EmployeeData = () => {
    const [employeeData, setEmployeeData] = useState([]);
    const [open, setOpen] = useState(false);
    const [loaded, setLoaded] = useState(false);
    const employmentsApi = new EmploymentsApi();
    const fetchData = async () => {
        const result = await employmentsApi.getHistory();
        setEmployeeData(result.data);
        setLoaded(true);
        console.log(result.data);
    }
    useEffect(() => {
        fetchData();
    }, []);
    const handleOpen = () => {
        setOpen(true);
    }
    const handleClose = () => {
        setOpen(false);
        fetchData();
    }
    return (
        <div style={{ padding: '25px' }}>
            <h2>Employee data</h2>
            <Button variant="contained" onClick={handleOpen}>New employee data</Button>
            <br />
            <br />
            {loaded ? <EmployeeDataTable employeeData={employeeData} /> : <CircularProgress />}
            <AddEmployeeData open={open} handleClose={handleClose} />
        </div>
    );
}

export default EmploymentsApi;