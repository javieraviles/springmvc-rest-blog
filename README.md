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
            "id": 2,
            "title": "titlePost1",
            "content": "contentPost1",
            "comments": [
                {
                    "id": 3,
                    "author": {
                        "id": 1,
                        "name": "authorName1",
                        "age": 30
                    },
                    "content": "contentComment1Post1"
                }
            ]
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
            "author": {
                "id":1
            },
            "content":"contentComment1Post1"
        }
    ```
 - Response (201 CREATED)
    ```json 
        {
            "id": 5,
            "title": "titlePost1",
            "content": "contentPost1",
            "comments": [
                {
                    "id": 8,
                    "author": {
                        "id": 1,
                        "name": "authorName1",
                        "age": 30
                    },
                    "content": "contentComment1Post1"
                },
                {
                    "id": 6,
                    "author": {
                        "id": 1,
                        "name": "authorName1",
                        "age": 30
                    },
                    "content": "contentComment1Post1"
                }
            ]
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

## Create Author
 - Method: POST
 - URI: /api/authors/
 - Body:
    ```json 
        {
            "name":"authorName1",
            "age":30
        }
    ```
 - Response (201 CREATED)
    ```json 
        {
            "id": 1,
            "name": "authorName1",
            "age": 30
        }
    ```

## Get Author comments
 - Method: GET
 - URI: /api/authors/{authorId}/comments
 - Response (200 OK):
    ```json 
        {
            "comments": [
                {
                    "id": 3,
                    "content": "contentComment1Post1",
                    "post": {
                        "id": 2
                    }
                },
                {
                    "id": 4,
                    "content": "contentComment1Post1",
                    "post": {
                        "id": 2
                    }
                }
            ]
        }
    ```
