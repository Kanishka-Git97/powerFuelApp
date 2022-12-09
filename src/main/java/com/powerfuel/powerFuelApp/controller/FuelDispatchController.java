package com.powerfuel.powerFuelApp.controller;

import com.powerfuel.powerFuelApp.dto.FuelDispatchDTO;
import com.powerfuel.powerFuelApp.dto.ResponseDTO;
import com.powerfuel.powerFuelApp.service.FuelDispatchService;
import com.powerfuel.powerFuelApp.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/fuelDispatch")
@CrossOrigin
public class FuelDispatchController {

    @Autowired
    private FuelDispatchService fuelDispatchService;

    @Autowired
    private ResponseDTO responseDTO;

//    @PostMapping("/saveFuelDispatch")
//    public FuelDispatchDTO saveFuelDispatch(@RequestBody FuelDispatchDTO fuelDispatchDTO){
//
//        return fuelDispatchService.saveFuelDispatch(fuelDispatchDTO);
//
//
//    }

    @PostMapping("/saveFuelDispatch2")
    public ResponseEntity saveFuelDispatch(@RequestBody FuelDispatchDTO fuelDispatchDTO){
        try{
                String res= fuelDispatchService.saveFuelDispatch(fuelDispatchDTO);
                if(res.equals("00")){
                    responseDTO.setCode(VarList.RSP_SUCCESS);
                    responseDTO.setMessage("Success");
                    responseDTO.setContent(fuelDispatchDTO);
                    return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
                    
                } else if (res.equals("06")) {
                    responseDTO.setCode(VarList.RSP_DUPLICATED);
                    responseDTO.setMessage("Already dispatched");
                    responseDTO.setContent(fuelDispatchDTO);
                    return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);


                }else {
                    responseDTO.setCode(VarList.RSP_FAIL);
                    responseDTO.setMessage("Error");
                    responseDTO.setContent(null);
                    return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);


                }
        }catch(Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);


        }

    }


}
