# BLOG API
University master exercise

## Get Posts
 - Method: GET
 - URI: /api/posts/
 - Response (200 OK):
    ```json 
        {
            "id": 1,
            "title": "titlePost1",
            "content": "contentPost1"
        },
        {
            "id": 2,
            "title": "titlePost2",
            "content": "contentPost2"
        }
    ```
## Get Single Post
 - Method: GET
 - URI: /api/posts/{postId}
 - Response (200 OK):
    ```json 
        {
            "id": 1,
            "title": "titlePost1",
            "content": "contentPost1",
            "comments": {}
        }
    ```
## Create Post
 - Method: POST
 - URI: /api/posts/
 - Body:
    ```json 
        {
            "title":"titlePost1",
            "content":"contentPost1"
        }
    ```
 - Response (201 CREATED)
    ```json 
        {
            "id": 1,
            "title": "titlePost1",
            "content": "contentPost1",
            "comments": {}
        }
    ```
## Update Post
 - Method: PUT
 - URI: /api/posts/{postId}
 - Body:
    ```json 
        {
            "title":"modifiedTitlePost1",
            "content":"modifiedContentPost1"
        }
    ```
 - Response (200 OK)
    ```json 
        {
            "id": 1,
            "title": "modifiedTitlePost1",
            "content": "modifiedContentPost1",
            "comments": {}
        }
    ```
## Delete Post
 - Method: DELETE
 - URI: /api/posts/{postId}
 - Response (200 OK)
    ```json 
        {
            "id": 1,
            "title": "modifiedTitlePost1",
            "content": "modifiedContentPost1",
            "comments": {}
        }
    ```
## Create comment on existing Post
 - Method: POST
 - URI: /api/posts/{postId}/comments
 - Body:
    ```json 
        {
            "name":"nameComment1Post1",
            "content":"contentComment1Post1",
            "comments": {}
        }
    ```
 - Response (201 CREATED)
    ```json 
        {
            "id": 1,
            "title": "modifiedTitlePost1",
            "content": "modifiedContentPost1",
            "comments": {
                "id": 1,
                "name":"nameComment1Post1",
                "content":"contentComment1Post1"
            }
        }
    ```
## Delete Comment
 - Method: DELETE
 - URI: /api/posts/{postId}/comments/{commentId}
 - Response (200 OK)
    ```json 
        {
            "id": 1,
            "title": "modifiedTitlePost1",
            "content": "modifiedContentPost1",
            "comments": {}
        }
    ```