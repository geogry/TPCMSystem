package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Post;

/**
 * ��ְλ����в���
 * @author GJ
 *
 */
public interface PostDao {

	/**
	 * ����id����ְλ��Ϣ
	 * @param id
	 * @return Post
	 */
	public Post findPostById(int id);
	
	/**
	 * �������е�ְλ��Ϣ
	 * @return List<Post>
	 */
	public List<Post> findAllPost();
	
	/**
	 * ���ְλ��Ϣ
	 * @param post
	 */
	public void addPost(Post post);
	
	/**
	 * ɾ��ְλ��Ϣ
	 * @param post
	 */
	public void deletePost(Post post);
}
