import { readFile, writeFile } from "fs/promises";

// console.log(import.meta.url);
// console.log(process.cwd().replaceAll('\\', '/'));

// const path = process.cwd().replaceAll('\\', '/') + "/index.html";    // Way 1

const path = new URL("./index.html", import.meta.url); // Way 2 - to refer to file paths in ES moduling
// console.log(path.pathname);

const data = await readFile(path); // this feature using `await` at top level is available in ES moduling not in commonJS
let template = data.toString();

const name = "Gedela Sivakrishna";
template = template.replace('{{name}}', name);

await writeFile(new URL("./output.html", import.meta.url), template);
