import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { TextField } from '@mui/material';
import { EmploymentsApi } from '../../api/api';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
};

export default function AddEmployeeData({ open, handleClose }) {
    const [id, setId] = React.useState("");
    const [salaryFactor, setSalaryFactor] = React.useState("");
    const [employed, setEmployed] = React.useState("");
    const employeeDataApi = new EmploymentsApi();
    const addEmployeeData = async () => {
        const result = await employeeDataApi.postEmploymentSalary(id, salaryFactor, employed);
        if (result.request.status === 200) {
            handleClose();
            setId("");
            setSalaryFactor("");
            setEmployed("");
        }
    }

    return (
        <div>

            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style}>
                    <Typography id="modal-modal-title" variant="h6" component="h2">
                        Add new employee data
                    </Typography>
                    <TextField
                        required
                        id="employeeId"
                        label="id"
                        value={id}
                        onChange={(event) => { setId(event.target.value) }}
                    />
                    <TextField
                        required
                        id="salaryFactor"
                        label="Salary factor"
                        value={salaryFactor}
                        onChange={(event) => { setSalaryFactor(event.target.value) }}
                    />
                    <TextField
                        required
                        id="employed"
                        label="Employed"
                        value={employed}
                        onChange={(event) => { setEmployed(event.target.value) }}
                    />
                    <div>
                        <Button variant="contained" onClick={addEmployeeData}>Add</Button>
                    </div>
                </Box>
            </Modal>
        </div>
    );
}