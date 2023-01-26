import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';


export default function EmployeesTable({employees, deleteEmploye, editEmploye}) {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>id</TableCell>
            <TableCell align="right">first name</TableCell>
            <TableCell align="right">last name</TableCell>
            <TableCell align="right">tax code</TableCell>
            <TableCell align="right">position</TableCell>
            <TableCell align="right">salary factor</TableCell>
            <TableCell align="right">salary</TableCell>
            <TableCell align="right">employed</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {employees.map((row) => (
            <TableRow
              key={row.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {row.id}
              </TableCell>
              <TableCell align="right">{row.firstName}</TableCell>
              <TableCell align="right">{row.lastName}</TableCell>
              <TableCell align="right">{row.taxCode}</TableCell>
              <TableCell align="right">{row.position}</TableCell>
              <TableCell align="right">{row.salaryFactor}</TableCell>
              <TableCell align="right">{row.salary}</TableCell>
              <TableCell align="right">{row.employed}</TableCell>
              <TableCell align="right">
                <IconButton onClick={() => editEmploye(row.id)}>
                  <EditIcon />
                </IconButton>
              </TableCell>
              <TableCell align="right">
                <IconButton onClick={() => deleteEmploye(row.id)}>
                  <DeleteIcon />
                </IconButton>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}