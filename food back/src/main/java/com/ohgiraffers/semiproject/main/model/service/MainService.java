package com.ohgiraffers.semiproject.main.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.main.model.dao.MainMapper;
import com.ohgiraffers.semiproject.main.model.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MainService implements MainServiceInter{

    private MainMapper mapper;

    public MainService(MainMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = mapper.selectTotalCount(searchMap);

        return result;

    }

    @Override
    public List<List<ProjectDTO>> findAllProject(SelectCriteria selectCriteria) {
        List<ProjectDTO> project = mapper.findAllProject(selectCriteria);
        List<List<ProjectDTO>> projectListDTO = new ArrayList<>(); //프로젝트 리스트안에 3개씩 담고 전체는 4개



        System.out.println("project.size() = " + project.size());

        System.out.println("project = " + project);
        List<ProjectDTO> project1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(project.size()>i){

                project1.add(project.get(i));
            }
        }
        List<ProjectDTO> project2 = new ArrayList<>();
        for (int i = 3; i < 6; i++) {
            if(project.size()>i) {
                project2.add(project.get(i));
            }
        }
        List<ProjectDTO> project3 = new ArrayList<>();
        for (int i = 6; i < 9; i++) {
            if(project.size()>i) {

                project3.add(project.get(i));
            }
        }
        List<ProjectDTO> project4 = new ArrayList<>();
        for (int i = 9; i < 12; i++) {
            if(project.size()>i) {

                project4.add(project.get(i));
            }
        }


        System.out.println("project1 = " + project1);
        System.out.println("project2 = " + project2);
        System.out.println("project3 = " + project3);
        System.out.println("project4 = " + project4);
//        리스트에 나눠담기


//        리스트에 넣기

        if(!project1.isEmpty()){
            projectListDTO.add(project1);
        }
        if(!project2.isEmpty()){
            projectListDTO.add(project2);
        }
        if(!project3.isEmpty()){
            projectListDTO.add(project3);
        }
        if(!project4.isEmpty()){
            projectListDTO.add(project4);
        }
        System.out.println("projectListDTO = " + projectListDTO);

        return projectListDTO;


    }
    @Override
    public List<ProjectDTO> firstNewProject() {

        List<ProjectDTO> project = mapper.firstNewProject();

        return project;
    }
    @Override
    public List<ProjectDTO> secondNewProject() {
        List<ProjectDTO> project = mapper.secondNewProject();

        return project;
    }
    @Override
    public List<ProjectDTO> firstReProject() {
        List<ProjectDTO> project = mapper.firstReProject();

        return project;
    }
    @Override
    public List<ProjectDTO> secondReProject() {
        List<ProjectDTO> project = mapper.secondReProject();

        return project;
    }
}

