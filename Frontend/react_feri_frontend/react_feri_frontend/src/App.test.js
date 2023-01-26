import { render, screen } from '@testing-library/react';
import React from 'react';
import EmployeesTable from './components/Employees/EmployeesTable';


it('checks if empty products table renders', () => {
  const products = [];
  render(<EmployeesTable products={products} />);
  expect(screen.getByText('name')).toBeInTheDocument();
});
