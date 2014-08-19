/* ========================================================================
 * Copyright 2014 monitor
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 monitor

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.monitor.sport.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.monitor.sport.logic.dto.SportDTO;
import co.edu.uniandes.csw.monitor.sport.logic.api._ISportLogicService;
import co.edu.uniandes.csw.monitor.sport.persistence.api.ISportPersistence;

public abstract class _SportLogicService implements _ISportLogicService {

	@Inject
	protected ISportPersistence persistance;

	public SportDTO createSport(SportDTO sport){
		return persistance.createSport( sport); 
    }

	public List<SportDTO> getSports(){
		return persistance.getSports(); 
	}

	public SportDTO getSport(Long id){
		return persistance.getSport(id); 
	}

	public void deleteSport(Long id){
	    persistance.deleteSport(id); 
	}

	public void updateSport(SportDTO sport){
	    persistance.updateSport(sport); 
	}	
}