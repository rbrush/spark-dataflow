/*
 * Copyright (c) 2015, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */

package com.cloudera.dataflow.hadoop;

import com.google.cloud.dataflow.sdk.testing.CoderProperties;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.junit.Test;

/**
 * Tests for WritableCoder.
 */
public class WritableCoderTest {

  @Test
  public void testIntWritableEncoding() throws Exception {
    IntWritable value = new IntWritable(42);
    WritableCoder<IntWritable> coder = WritableCoder.of(IntWritable.class);

    CoderProperties.coderDecodeEncodeEqual(coder, value);
  }

  @Test
  public void testNullWritableEncoding() throws Exception {
    WritableCoder<NullWritable> coder = WritableCoder.of(NullWritable.class);

    CoderProperties.coderDecodeEncodeEqual(coder, NullWritable.get());
  }
}
