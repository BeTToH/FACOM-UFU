The program will create a inverted index with the words 
in the document base, then it will perform a query and 
return how many documents and which ones satisfy the query.

The query file must inform a query,
e.g., "ball & !soccer", the program will return all documents
that contain the word ball and don't contain the word soccer.


To run, u need to inform the document base and the query:
py boolean_model.py document_base query.txt

As a example, the repository contains a document base called
base_samba and a query. To run it:
py boolean_model.py base_samba query.txt


At the end, it will create a file "answer.txt" with
the answer to your search.