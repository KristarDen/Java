document.addEventListener("DOMContentLoaded",() => {
    const container =
        document.getElementById("books-container");
    if(!container) throw "books-container not found";
    // fetch data (books)
    fetch("books")
        .then(r => r.json())
        .then(j => fillContainer(container, j));

});

function fillContainer(container, j) {
    // fetch template (html)
    fetch("templates/bookitem.html")
        .then(r => r.text())
        .then( tpl => {
            var html = "" ;
            let id = 1;
            for(let book of j){
                html += tpl
                    .replace("{{author}}", book["author"])
                    .replace("{{title}}",  book["title"])
                    .replace("{{cover}}",  book["cover"])
                    .replace("{{id}}",  book["id"] )
                    .replace("{{id}}",  book["id"]);
            }
            container.innerHTML = html;
        });

}
