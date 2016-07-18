package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Post;

/**
 * 对职位表进行操作
 * @author GJ
 *
 */
public interface PostDao {

	/**
	 * 根据id查找职位信息
	 * @param id
	 * @return Post
	 */
	public Post findPostById(int id);
	
	/**
	 * 查找所有的职位信息
	 * @return List<Post>
	 */
	public List<Post> findAllPost();
	
	/**
	 * 添加职位信息
	 * @param post
	 */
	public void addPost(Post post);
	
	/**
	 * 删除职位信息
	 * @param post
	 */
	public void deletePost(Post post);
}
