package com.powerfuel.powerFuelApp.controller;

import com.powerfuel.powerFuelApp.dto.FuelAllocationDTO;
import com.powerfuel.powerFuelApp.dto.ResponseDTO;
import com.powerfuel.powerFuelApp.model.FuelAllocation;
import com.powerfuel.powerFuelApp.repository.FuelAllocationRepository;
import com.powerfuel.powerFuelApp.service.FuelAllocationService;
import com.powerfuel.powerFuelApp.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fuelAllocation")
@CrossOrigin
public class FuelAllocationController {

    @Autowired
    private FuelAllocationService fuelAllocationService;


//    adding to check

    @Autowired
    private ResponseDTO responseDTO;




//    @PostMapping("/saveFuelAllocation")
//    public FuelAllocationDTO saveFuelAllocation(@RequestBody FuelAllocationDTO fuelAllocationDTO) {
///
//
//        return fuelAllocationService.saveFuelAllocation(fuelAllocationDTO);
//    }


    @PostMapping(value = "/saveFuelAllocation2")
    public ResponseEntity saveFuelAllocation(@RequestBody FuelAllocationDTO fuelAllocationDTO){

        try{

            String res= fuelAllocationService.saveFuelAllocation(fuelAllocationDTO);

            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(fuelAllocationDTO);
                return new ResponseEntity(responseDTO,HttpStatus.ACCEPTED);
                
            } else if (res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Duplicate allocation");
                responseDTO.setContent(fuelAllocationDTO);
                return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);


            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);


            }

        }catch (Exception ex){

            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }




//    @GetMapping("/getFuelAllocations")
//    public List<FuelAllocationDTO> getFuelAllocations(){
//
//        return fuelAllocationService.getAllAllocations();
//
//    }


    @GetMapping("/getFuelAllocations2")
    public ResponseEntity getFuelAllocations(){
        try{
            List<FuelAllocationDTO> fuelAllocationDTOList=fuelAllocationService.getAllAllocations();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(fuelAllocationDTOList);
            return new ResponseEntity(responseDTO,HttpStatus.ACCEPTED);


        }catch (Exception ex){

            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);


        }

    }








    }
