package biweekly.io.scribe.property;

import biweekly.ICalDataType;
import biweekly.ICalVersion;
import biweekly.parameter.ICalParameters;
import biweekly.property.Attendee;

/*
 Copyright (c) 2013, Michael Angstadt
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
 * Marshals {@link Attendee} properties.
 * @author Michael Angstadt
 */
public class AttendeeScribe extends TextPropertyScribe<Attendee> {
	public AttendeeScribe() {
		super(Attendee.class, "ATTENDEE", ICalDataType.CAL_ADDRESS);
	}

	@Override
	protected ICalParameters _prepareParameters(Attendee property, ICalVersion version) {
		String rsvp = property.getParameter(ICalParameters.RSVP);
		if (rsvp == null) {
			return property.getParameters();
		}

		ICalParameters copy = new ICalParameters(property.getParameters());
		copy.remove(ICalParameters.RSVP, rsvp);

		switch (version) {
		case V1_0:
			if ("FALSE".equalsIgnoreCase(rsvp)) {
				rsvp = "NO";
			} else if ("TRUE".equalsIgnoreCase(rsvp)) {
				rsvp = "YES";
			}
			break;

		default:
			if ("NO".equalsIgnoreCase(rsvp)) {
				rsvp = "FALSE";
			} else if ("YES".equalsIgnoreCase(rsvp)) {
				rsvp = "TRUE";
			}
			break;
		}

		copy.put(ICalParameters.RSVP, rsvp);

		return copy;
	}

	@Override
	protected Attendee newInstance(String value) {
		return new Attendee(value);
	}
}