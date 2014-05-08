#!/bin/bash
bash clean.sh
mvn exec:java -Dexec.mainClass=disease_comparison.DiseaseComparisonDriver -Dexec.args="src/test/resources/mp-subset-1-labels.tsv src/test/resources/mp-subset-1-edges.tsv src/test/resources/mgi-gene2mp-subset-1-labels.tsv src/test/resources/mgi-gene2mp-subset-1.tsv"
