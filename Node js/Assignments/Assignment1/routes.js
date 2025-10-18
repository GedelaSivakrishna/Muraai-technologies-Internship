
const requestHandler = (req, res) => {
    const url = req.url;
    const method = req.method;

    if(url === "/") {
        res.write("<html>");
        res.write("<head></head>");
        res.write("<body> <h1> Welcome to Home Page </h1> <form action='/create-user' method='POST' ><input type='text' name='username'><button type='submit'>Send</button></form> </body>");
        res.write("</html>");
        return res.end();
    }
    else if (url === "/users") {
        res.write("<html>");
        res.write("<head></head>");
        res.write("<body><ul><li>Gedela</li><li>Sivakrishna</li><li>Gedela Sivakrishna</li></ul></body>");
        res.write("</html>");
        return res.end();
    }
    else if (url === "/create-user" && method === 'POST') {
        const body = [];
        req.on("data", (chunk) => {
            body.push(chunk);
        });

        req.on("end", () => {
            const parsedBody = Buffer.concat(body).toString();
            const username = parsedBody.split("=")[1];
            console.log(username);
            res.statusCode = 302;
            res.setHeader("Location", "/");
            return res.end();
        })
    }
}

exports.handler = requestHandler;