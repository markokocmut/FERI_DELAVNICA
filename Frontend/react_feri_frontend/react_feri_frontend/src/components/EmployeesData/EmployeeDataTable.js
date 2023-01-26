import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import DoneIcon from '@mui/icons-material/Done';
import CloseIcon from '@mui/icons-material/Close';

export default function EmployeeDataTable({ employeeData }) {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 350 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>id</TableCell>
            <TableCell align="right"><b>date</b></TableCell>
            <TableCell align="right"><b>ID</b></TableCell>
            <TableCell align="right"><b>salary factor</b></TableCell>
            <TableCell align="right"><b>employed</b></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {employeeData.map((row) => (
            <TableRow
              key={row.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">{row.id}</TableCell>
              <TableCell align="right">{row.dateTime}</TableCell>
              <TableCell align="right">{row.id}</TableCell>
              <TableCell align="right">{row.salaryFactor}</TableCell>
              <TableCell align="right">{row.employed ? <DoneIcon sx={{ color: 'green' }} /> : <CloseIcon sx={{ color: 'red' }} />}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}