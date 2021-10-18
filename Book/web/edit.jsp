<%@ page contentType="text/html;charset=UTF-8" %>
<div class="book-add-form">
    <form method="post" enctype="multipart/form-data">
        <input id="cover" name="cover" type="file">
        <label>Author <input name="author" value="${author}"></label>
        <br/>
        <label>Title <input value="${name}" name="title"></label>
        <br/>
        <input type="submit" value="Add"/>
    </form>
</div>

<script>

</script>