import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { TextField } from '@mui/material';
import {EmploymentsApi, MeasurementsApi} from '../../api/api';

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

export default function EditEmploye({ open, handleClose, id }) {
    const [id, setId] = React.useState("");
    const [firstName, setFirstName] = React.useState("");
    const [lastName, setLastName] = React.useState("");
    const [taxCode, setTaxCode] = React.useState("");
    const [position, setPosition] = React.useState("");
    const [salaryFactor, setSalaryFactor] = React.useState("");
    const [salary, setSalary] = React.useState("");
    const [employed, setEmployed] = React.useState("");
    const employmentsApi = new EmploymentsApi();

    React.useEffect(() => {
        const fetchData = async () => {
            const result = await employmentsApi.getEmployeById(id);
            if (result.request.status === 200) {
                setId(result.data.id);
                setFirstName(result.data.firstName);
                setLastName(result.data.lastName);
                setTaxCode(result.data.taxCode);
                setPosition(result.data.position);
                setSalaryFactor(result.data.salaryFactor);
                setSalary(result.data.salary);
                setEmployed(result.data.employed);
            }
        }
        if (open && id) {
            fetchData();
        }
    }, [open, id]);
    const editEmploye = async () => {
        const result = await employmentsApi.putEmploye(id, firstName, lastName, taxCode, position, salaryFactor, salary, employed);
        if (result.request.status === 200) {
            setFirstName("");
            setLastName("");
            setTaxCode("");
            setPosition("");
            setSalaryFactor("");
            setSalary("");
            setEmployed("");
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
                        Edit product
                    </Typography>
                    <br />
                    <br />
                    <TextField
                        required
                        id="firstName"
                        label="first name"
                        value={firstName}
                        onChange={(event) => { setFirstName(event.target.value) }}
                    />
                    <br />
                    <br />
                    <TextField
                        required
                        id="lastName"
                        label="last name"
                        value={lastName}
                        onChange={(event) => { setLastName(event.target.value) }}
                    />
                    <br />
                    <br />
                    <TextField
                        required
                        id="taxCode"
                        label="tax code"
                        value={taxCode}
                        onChange={(event) => { setTaxCode(event.target.value) }}
                    />
                    <br />
                    <br />
                    <TextField
                        required
                        id="position"
                        label="position"
                        value={position}
                        onChange={(event) => { setPosition(event.target.value) }}
                    />
                    <br />
                    <br />
                    <TextField
                        required
                        id="salaryFactor"
                        label="salary factor"
                        value={salaryFactor}
                        onChange={(event) => { setSalaryFactor(event.target.value) }}
                    />
                    <br />
                    <br />
                    <TextField
                        required
                        id="salary"
                        label="salary"
                        value={salary}
                        onChange={(event) => { setSalary(event.target.value) }}
                    />
                    <br />
                    <br />
                    <TextField
                        required
                        id="employed"
                        label="employed"
                        value={employed}
                        onChange={(event) => { setEmployed(event.target.value) }}
                    />
                    <br />
                    <br />
                    <div>
                        <Button variant="contained" onClick={editEmploye()}>Save</Button>
                    </div>
                </Box>
            </Modal>
        </div>
    );
}