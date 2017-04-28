<?php

class test extends testWrapper
{
    public function test_002() {
        $this->description = 'Sample test 02';
        $this->expected = 'true';

        if (2 === 2) {
            echo "true";
        }
        else {
            echo "false";
        }
    }
}