////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2017, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////
package org.javcode.cucumber.spring.steps;

import cucumber.api.CucumberOptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("/cucumber.xml")
@CucumberOptions(plugin = { "pretty", "html:target/cucumber" })
public class BaseTest
{
    @Autowired
    protected World world;
}
