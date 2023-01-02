package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.dto.FuelDispatchDTO;
import com.powerfuel.powerFuelApp.model.FuelDispatch;
import com.powerfuel.powerFuelApp.repository.FuelDispatchRepository;
import com.powerfuel.powerFuelApp.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FuelDispatchService {

    @Autowired
    private FuelDispatchRepository fuelDispatchRepository;

    @Autowired
    private ModelMapper modelMapper;

//    public FuelDispatchDTO saveFuelDispatch(FuelDispatchDTO fuelDispatchDTO){
//
//        fuelDispatchRepository.save(modelMapper.map(fuelDispatchDTO,FuelDispatch.class));
//        return fuelDispatchDTO;
//
//
//    }

    public String saveFuelDispatch(FuelDispatchDTO fuelDispatchDTO){

            if(fuelDispatchRepository.existsById(fuelDispatchDTO.getDispatchID())){

                return VarList.RSP_DUPLICATED;

            }else {
                fuelDispatchRepository.save(modelMapper.map(fuelDispatchDTO, FuelDispatch.class));
                    return VarList.RSP_SUCCESS;
            }

    }



}
