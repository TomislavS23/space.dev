/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.space.print;

import dev.space.utilities.DateParser;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

/**
 *
 * @author tomislav
 */
public class DatePublishedAdapter extends XmlAdapter<String, Date>{

    @Override
    public Date unmarshal(String txt) throws Exception {
        return DateParser.FormatDate(txt);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return DateParser.FormatToString(date);
    }
    
}
