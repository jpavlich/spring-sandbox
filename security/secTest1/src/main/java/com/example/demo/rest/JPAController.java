/**
 * Copyright (c) 2016 All Rights Reserved by the SDL Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.demo.rest;

import com.sdl.odata.controller.AbstractODataController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The default entrypoint for the JPA example datasource.
 * @author Renze de Vries
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/jpa.svc/**")
//,consumes={"application/xml", "application/json","text/html","application/xhtml+xml"}
public class JPAController extends AbstractODataController {
	
}
