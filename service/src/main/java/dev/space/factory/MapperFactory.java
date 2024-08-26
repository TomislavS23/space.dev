/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.space.factory;

import org.modelmapper.ModelMapper;

/**
 *
 * @author tomislav
 */
public final class MapperFactory {
    
    public MapperFactory() {
    }
    
    public static ModelMapper InitializeMapper(){
        return new ModelMapper();
    }
}
