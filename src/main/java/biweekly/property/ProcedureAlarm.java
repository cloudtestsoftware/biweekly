package biweekly.property;

import biweekly.component.VAlarm;

/*
 Copyright (c) 2013-2014, Michael Angstadt
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met: 

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer. 
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * Defines an alarm that executes a procedure when triggered. It is recommended
 * that the {@link VAlarm} component be used to created alarms.
 * @author Michael Angstadt
 * @see <a href="http://www.imc.org/pdi/vcal-10.doc">vCal 1.0 p.33</a>
 * @see VAlarm#procedure
 */
public class ProcedureAlarm extends VCalAlarmProperty {
	private String path;

	/**
	 * @param path the path or name of the procedure to run when the alarm is
	 * triggered
	 */
	public ProcedureAlarm(String path) {
		this.path = path;
	}

	/**
	 * Gets the path or name of the procedure to run when the alarm is
	 * triggered.
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path or name of the procedure to run when the alarm is
	 * triggered.
	 * @param path the path
	 */
	public void getPath(String path) {
		this.path = path;
	}
}
