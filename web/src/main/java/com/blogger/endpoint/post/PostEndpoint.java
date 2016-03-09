package com.blogger.endpoint.post;

import com.blogger.converter.Converter;
import com.blogger.dto.PostDTO;
import com.blogger.entity.Post;
import com.blogger.service.PostService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikolay Yashchenko
 */
@Path("/post")
@Stateless
public class PostEndpoint {

    @Inject
    private PostService postService;

    @Inject
    private Converter<PostDTO, Post> converterToEntity;

    @Inject
    private Converter<Post, PostDTO> converterToDTO;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPosts(@PathParam("offset") int offset,
                             @PathParam("stepSize") int stepSize,
                             @PathParam("sort") String sort,
                             @PathParam("userId") Long userId) {
        if(stepSize <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        // todo fix problem with lambdas
        List<Post> posts = postService.getByParameters(offset, stepSize, sort, userId);
        List<PostDTO> postDTOs = new ArrayList<>();
        for(Post post : posts) {
            postDTOs.add(converterToDTO.convert(post));
        }
//        List<PostDTO> postDTOs = postService.getByParameters(offset, stepSize, sort, userId).stream()
//                .map(converterToDTO::convert)
//                .collect(Collectors.toList());
        return Response.ok()
                .entity(postDTOs)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPost(@PathParam("id") Long postId) {
        if(postId <= 0L) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }

        return Response.ok()
                .entity(converterToDTO.convert(postService.read(postId)))
                .build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPost(@Valid PostDTO postDTO) {
        Post post = postService.create(converterToEntity.convert(postDTO));
        return Response.ok()
                .entity(converterToDTO.convert(post))
                .build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePost(@PathParam("id") Long postId,
                               @Valid PostDTO postDTO) {
        if(postId <= 0L) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }

        postDTO.setPostId(postId);
        Post post = postService.update(converterToEntity.convert(postDTO));
        return Response.ok()
                .entity(converterToDTO.convert(post))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePost(@PathParam("id") Long postId) {
        if(postId <= 0L) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        postService.delete(postService.read(postId));
        return Response.ok()
                .build();
    }
}
