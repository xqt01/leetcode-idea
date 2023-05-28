#!/bin/bash

source ./script/query_problem.sh
get_question_slug $1
query_problem ${LEETCODE_URL} ${QUESTION_TITLE_SLUG} 

#parse java file name
CLASS_NAME=""
IFS='-' read -ra words <<< "${QUESTION_TITLE_SLUG}"
for word in "${words[@]}"; do
  capitalized=$(tr '[:lower:]' '[:upper:]' <<< "${word:0:1}")
  capitalized+="${word:1}"
  CLASS_NAME+="$capitalized"
done

#parse java package name
package_name="q${QUESTION_ID}_${QUESTION_TITLE_SLUG//-/_}"

#create java file
cd ./algorithm/java/
mkdir ${package_name}
cd ${package_name}

file_name="${CLASS_NAME}.java"
touch "${file_name}"

echo "package ${package_name};" > "${file_name}"
echo "" >> "${file_name}"
echo "public class ${CLASS_NAME} {}" >> "${file_name}"

echo ""
echo "|${QUESTION_ID}|[${QUESTION_TITLE}]($1)|[Java](./algorithm/java/${package_name}/${file_name})|${QUESTION_DIFFICULTY}|"
echo "" 