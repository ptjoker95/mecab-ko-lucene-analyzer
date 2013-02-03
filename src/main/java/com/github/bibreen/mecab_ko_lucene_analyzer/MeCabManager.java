/*******************************************************************************
 * Copyright 2013 Yongwoon Lee, Yungho Yu
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.github.bibreen.mecab_ko_lucene_analyzer;

import org.chasen.mecab.Lattice;
import org.chasen.mecab.Model;
import org.chasen.mecab.Tagger;

public final class MeCabManager {
  static private Model model;
  static {
    try {
      System.loadLibrary("MeCab");
    } catch (UnsatisfiedLinkError e) {
      System.err.println(
          "Cannot load the native code.\n"
          + "Make sure your LD_LIBRARY_PATH contains MeCab.so path.\n" + e);
      System.exit(1);
    }
    model = new Model("-d /usr/local/lib/mecab/dic/mecab-ko-dic");
  }
 
  private Tagger tagger;
  private Lattice lattice;
  
  MeCabManager() {
    tagger = model.createTagger();
    lattice = model.createLattice();
  }

  public Tagger getTagger() {
    return tagger;
  }
  
  public Lattice getLattice() {
    return lattice;
  }
}
