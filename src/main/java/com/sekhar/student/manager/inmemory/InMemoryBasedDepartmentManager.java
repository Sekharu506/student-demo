package com.sekhar.student.manager.inmemory;

import java.util.Set;
import com.sekhar.student.model.*;

public interface InMemoryBasedDepartmentManager {

	public void setDepartment(Department department);

	public void removeDepartment(int departmentId);

	public Department getDepartment(int departmentId);

	public Set<Department> getDepartments();

}
