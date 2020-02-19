# Comparator Library

Comparator Library is used to compare 2 API responses (HTTP/HTTPS)

## Description

Created a comparator library that will compare 2 API responses which
1. Could be nested or unordered in nature
  2. Can compare millions of requests without any memory issues


## Scope/Assumptions

- Considered API response as blank for below cases:
  1. Any API which gives response code other than 200 
  2. If any URL is not having proper protocol i.e. http,https,www etc...
- Considered APIs with GET request method only
- Not handled cases for APIs which requires authorization/authentication


## Development Approach

- This is the library we use to read URLs from 2 files
- Used HTTPclient library to get response from urls
- Created parseJSON method to parse response which checks whether jsonnode is array,object or value
- Created compare method(passed map of response 1 and response 2 as parameters), to compare responses on the basis of key-value pairs. Following criteria were used to draw the comparison:
  1. If the number of keys match across both the responses, then
  2. If the keys match across both the responses, then
  3. If the values corresponding to specific key also match across both the responses

- Created printResult method, to print output in required format


## Testing Approach
  
- Following testcases were considered using TestNG
  1. If both the URL give same response, it should be able to give output in the format of URL1 equals URL2
  2. If both the URL does not give same response, it should be able to give output in the format of URL1 not equals URL2
  3. If both of the URLs has blank response, it should be able to give output in the format of URL1 not equals URL2
  4. If one or both of the URLs have exception eg. response code !=200, file has unequal urls, file has blank entry in it, the program should not terminated
- Tested with 1000 requests, to ensure there are no memory issues


## Installation

1. Eclipse
2. Maven
3. TestNG

## Maven Build

- Create Maven build as "clean install". 
  Command: mvn clean install
- So a jar file will be generated
- Execute project from command prompt
   java -jar <jarfilename>.jar file1 file2