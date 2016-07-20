#!/usr/bin/env bash

# create student dirs
while read -r student_line; do
    student_id=${student_line%% *}
    mkdir -p output/$student_id
    #echo "$student_line" >> output/$student_id/Details.txt
done < input/Students.txt

for block_dir in input/*/; do
    block=${block_dir#*/}
    block=${block%/}
    echo $block
    for module_file in $block_dir/*; do
        module_id=${module_file##*/}
        module_id=${module_id%.txt}
        while read -r result_line; do
            student_id=${result_line% *}
            mark=${result_line#* }
            echo "$module_id $mark >> output/$student_id/$block"
        done < $module_file
    done
done
