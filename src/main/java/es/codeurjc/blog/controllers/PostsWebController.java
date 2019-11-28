package es.codeurjc.blog.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.blog.models.Comment;
import es.codeurjc.blog.models.Post;
import es.codeurjc.blog.services.PostService;

@Controller
public class PostsWebController {

	@Autowired
	private PostService postService;

	@GetMapping("/")
	public String showPosts(Model model) {
		return loadPosts(model);
	}

	@GetMapping("/createPost")
	public String createPost(Model model) {
		return "create_post";
	}

	@PostMapping("/createPost")
	public String createPost(Model model, @RequestParam String title, @RequestParam String content) {
		Post post = new Post();
		post.setTitle(title);
		post.setContent(content);
		post = postService.createPost(post);
		return loadPosts(model);
	}

	@GetMapping("/showPostDetail/{postId}")
	public String showPostDetail(Model model, @PathVariable("postId") Long postId) {
		return loadPostDetails(model, postId, "");
	}

	@PostMapping("/createComment/{postId}")
	public String createComment(Model model, @PathVariable("postId") Long postId, @RequestParam String name,
			@RequestParam String content) {
		final Comment comment = new Comment();
		comment.setName(name);
		comment.setContent(content);
		postService.addCommentToPost(comment, postId);
		return loadPostDetails(model, postId, name);
	}

	@GetMapping("/deleteComment/{postId}/{commentId}")
	public String showPostDetail(Model model, @PathVariable("postId") Long postId,
			@PathVariable("commentId") Long commentId) {
		postService.removeCommentFromPost(postId, commentId);
		return loadPostDetails(model, postId, "");
	}

	private String loadPosts(Model model) {
		final Collection<Post> posts = postService.getPosts();
		model.addAttribute("posts", posts);
		return "posts";
	}

	private String loadPostDetails(Model model, Long postId, String userName) {
		final Post post = postService.getPost(postId);
		model.addAttribute("post", post);
		model.addAttribute("postId", post.getId());
		model.addAttribute("comments", post.getComments().values());
		model.addAttribute("userName", userName);
		return "post_detail";
	}
}
