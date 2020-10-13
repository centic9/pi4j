package com.pi4j.component.access;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Device Abstractions
 * FILENAME      :  TM1638Test.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2020 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import com.pi4j.component.access.TM1638;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This test mostly only covers code, but does not fully verify correct
 * handling of the actual protocol of the TM1638 button device
 */
public class TM1638Test {
    private final GpioController gpio = mock(GpioController.class);

    private final GpioPinDigitalOutput dio = mock(GpioPinDigitalOutput.class);
    private final GpioPinDigitalOutput clk = mock(GpioPinDigitalOutput.class);
    private final GpioPinDigitalOutput stb = mock(GpioPinDigitalOutput.class);

    @Before
    public void setUp() {
        when(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "DIO")).thenReturn(dio);
        when(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "CLK")).thenReturn(clk);
        when(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "STB")).thenReturn(stb);
    }

    @Test
    public void testText() {
        TM1638 tm1638 = new TM1638(gpio, RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
        tm1638.enable();

        tm1638.set_text("");
        tm1638.set_text("a");
        tm1638.set_text("abcdefghijklmnopqrstuvwxyz");
        tm1638.set_text("              ");
        tm1638.set_text("1.234E237");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTextFails() {
        TM1638 tm1638 = new TM1638(gpio, RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
        tm1638.enable();

        tm1638.set_text("...............");
    }

    @Test
    public void testPow2() {
        assertEquals(1, TM1638.pow2(0));
        assertEquals(2, TM1638.pow2(1));
        assertEquals(4, TM1638.pow2(2));
        assertEquals(8, TM1638.pow2(3));
        assertEquals(16, TM1638.pow2(4));
        assertEquals(32, TM1638.pow2(5));
        assertEquals(64, TM1638.pow2(6));
        assertEquals(128, TM1638.pow2(7));
        assertEquals(256, TM1638.pow2(8));
        assertEquals(512, TM1638.pow2(9));
        assertEquals(1024, TM1638.pow2(10));
        assertEquals(524288, TM1638.pow2(19));
        assertEquals(1048576, TM1638.pow2(20));
        assertEquals(536870912, TM1638.pow2(29));
        assertEquals(1073741824, TM1638.pow2(30));

        // at most 2 to the power of 30 can be computed for integer
        assertEquals(Integer.MAX_VALUE, TM1638.pow2(31));
        assertEquals(Integer.MAX_VALUE, TM1638.pow2(32));
        assertEquals(Integer.MAX_VALUE, TM1638.pow2(33));
        assertEquals(Integer.MAX_VALUE, TM1638.pow2(40));
        assertEquals(Integer.MAX_VALUE, TM1638.pow2(41));
        assertEquals(Integer.MAX_VALUE, TM1638.pow2(24636));
        assertEquals(Integer.MAX_VALUE, TM1638.pow2(Integer.MAX_VALUE));
    }

    @Test
    public void testButtons() {
        GpioPinDigitalInput dio = mock(GpioPinDigitalInput.class);
        when(gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, "DIO", PinPullResistance.PULL_UP)).thenReturn(dio);

        TM1638 tm1638 = new TM1638(gpio, RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
        tm1638.enable();

        assertEquals(0, tm1638.get_buttons());
        assertEquals(0, tm1638.get_buttons64());
    }
}
