/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreemnets.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0 
 * (the "License"); you may not use this file except in compliance with 
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package opennlp.maxent.io;

import opennlp.maxent.*;
import opennlp.model.AbstractModel;

import java.io.*;
import java.util.zip.*;

/**
 * Model writer that saves models in binary format.
 *
 * @author      Jason Baldridge
 * @version     $Revision: 1.3 $, $Date: 2008/09/28 18:04:30 $
 */
public class BinaryGISModelWriter extends GISModelWriter {
    DataOutputStream output;

   /**
     * Constructor which takes a GISModel and a File and prepares itself to
     * write the model to that file. Detects whether the file is gzipped or not
     * based on whether the suffix contains ".gz".
     *
     * @param model The GISModel which is to be persisted.
     * @param f The File in which the model is to be persisted.
     */
    public BinaryGISModelWriter (AbstractModel model, File f) throws IOException {

	super(model);
	
	if (f.getName().endsWith(".gz")) {
	    output = new DataOutputStream(
		         new GZIPOutputStream(new FileOutputStream(f)));
	}
	else {
	    output = new DataOutputStream(new FileOutputStream(f));
	}
    }

   /**
     * Constructor which takes a GISModel and a DataOutputStream and prepares
     * itself to write the model to that stream.
     *
     * @param model The GISModel which is to be persisted.
     * @param dos The stream which will be used to persist the model.
     */
    public BinaryGISModelWriter (AbstractModel model, DataOutputStream dos) {
	super(model);
	output = dos;
    }

    protected void writeUTF (String s) throws java.io.IOException {
	output.writeUTF(s);
    }

    protected void writeInt (int i) throws java.io.IOException {
	output.writeInt(i);
    }
    
    protected void writeDouble (double d) throws java.io.IOException {
	output.writeDouble(d);
    }

    protected void close () throws java.io.IOException {
	output.flush();
	output.close();
    }

}
