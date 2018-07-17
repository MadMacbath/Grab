package com.macbeth.algorithm.mapper;

import com.macbeth.algorithm.domain.lagou.JobInformation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:macbeth
 * Date:2018/7/11
 * Time:11:27
 **/
@Service
public interface JobInformationMapper {
    JobInformation selectJobInformation(Long id);
    void saveJobInformation(JobInformation jobInformation);
    void saveJobInformations(List<JobInformation> list);
    JobInformation selectInformation();
}
