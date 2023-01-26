import React from 'react';
import { Routes, Route } from "react-router-dom";
import Measurements from '../EmployeesData/EmployeeData';
import PageNotFound from "../PageNotFound/PageNotFound";
import Employees from '../Employees/Employees';

const Main = () => {
    return (
        <Routes>
            <Route path="/" element={<EmployeesData />} />
            <Route path="/employees" element={<Employees />} />
            <Route path="*" element={<PageNotFound />} />
        </Routes>
    );
}

export default Main;