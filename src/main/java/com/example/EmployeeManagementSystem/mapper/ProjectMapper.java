package com.example.EmployeeManagementSystem.mapper;

import com.example.EmployeeManagementSystem.Repository.ClientRepository;
import com.example.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.Repository.TaskRepository;
import com.example.EmployeeManagementSystem.dto.ProjectDTO;
import com.example.EmployeeManagementSystem.entity.Client;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.entity.Project;
import com.example.EmployeeManagementSystem.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ProjectMapper {
    @Autowired
    private ClientRepository clientRepo;
    @Autowired
    private TaskRepository taskRepo ;

    public ProjectDTO entityToDto(Project project) {

        log.debug("Mapping Project Entity to DTO: {}", project);

        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setStatus(project.getStatus());
        dto.setProjectStartDate(project.getProjectStartDate());
        dto.setProjectEndDate(project.getProjectEndDate());
        dto.setClientId(project.getClient() != null ? project.getClient().getId() : null);


        return dto;
    }

    public Project dtoToEntity(ProjectDTO dto) {

        log.debug("Mapping Project dtoToEntity : {}", dto);

        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setProjectStartDate(dto.getProjectStartDate());
        project.setProjectEndDate(dto.getProjectEndDate());

        if (dto.getClientId() != null) {

            log.info("checking");
            Client client = clientRepo.findById(dto.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            project.setClient(client);

        }
        return project;
    }
}
