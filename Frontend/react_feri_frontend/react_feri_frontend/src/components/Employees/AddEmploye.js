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

export default function AddEmploye({ open, handleClose }) {
    const [firstName, setFirstName] = React.useState("");
    const [lastName, setLastName] = React.useState("");
    const [taxCode, setTaxCode] = React.useState("");
    const [position, setPosition] = React.useState("");
    const [salaryFactor, setSalaryFactor] = React.useState("");
    const [salary, setSalary] = React.useState("");
    const [employed, setEmployed] = React.useState("");
    const employmentsApi = new EmploymentsApi();
    const addEmploye = async () => {
        const result = employmentsApi.postEmploye(firstName, lastName, taxCode, position, salaryFactor, salary, employed);
        if (result.request.status === 200) {
            handleClose();
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
                        Add new employe
                    </Typography>
                    <TextField
                        required
                        id="firstName"
                        label="Employe first name"
                        value={firstName}
                        onChange={(event) => { setFirstName(event.target.value) }}
                    />
                    <TextField
                        required
                        id="lastName"
                        label="Employe last name"
                        value={lastName}
                        onChange={(event) => { setLastName(event.target.value) }}
                    />
                    <TextField
                        required
                        id="taxCode"
                        label="Employe tax code"
                        value={taxCode}
                        onChange={(event) => { setTaxCode(event.target.value) }}
                    />
                    <TextField
                        required
                        id="taxCode"
                        label="Employe tax code"
                        value={taxCode}
                        onChange={(event) => {setTaxCode(event.target.value) }}
                    />
                    <TextField
                        required
                        id="position"
                        label="Employe position"
                        value={position}
                        onChange={(event) => {setPosition(event.target.value) }}
                    />
                    <TextField
                        required
                        id="salaryFactor"
                        label="Employe salary factor"
                        value={salaryFactor}
                        onChange={(event) => {setSalaryFactor(event.target.value) }}
                    />
                    <TextField
                        required
                        id="salary"
                        label="Employe salary"
                        value={salary}
                        onChange={(event) => {setSalary(event.target.value) }}
                    />
                    <TextField
                        required
                        id="employed"
                        label="Is employee employed"
                        value={employed}
                        onChange={(event) => {setEmployed(event.target.value) }}
                    />
                    <div>
                        <Button variant="contained"
                            onClick={() => {
                                addEmploye();
                                setFirstName("");
                                setLastName("");
                                setTaxCode("");
                                setPosition("");
                                setSalaryFactor("0.0");
                                setSalary("899.0");
                                setEmployed(true);
                            }}>
                            Add
                        </Button>
                    </div>
                </Box>
            </Modal>
        </div>
    );
}