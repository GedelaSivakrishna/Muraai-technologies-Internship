const { Telegraf } = require('telegraf')
const { message } = require('telegraf/filters')
const axios =  require("axios");
require('dotenv').config()

const bot = new Telegraf(process.env.BOT_TOKEN);

const binarySearch = `
    function binary_search(A, n, T) is
    L := 0
    R := n − 1
    while L ≤ R do
        m := L + floor((R - L) / 2)
        if A[m] < T then
            L := m + 1
        else if A[m] > T then
            R := m − 1
        else:
            return m
    return unsuccessful
`;

try {
    bot.start((ctx) => ctx.reply("Welcome to Sivakrishna's bot"));
    bot.help((ctx) => ctx.reply("Send me a sticker.."));
    bot.on(message('sticker'), (ctx) => ctx.reply('👍'));
    bot.hears('hi', (ctx) => ctx.reply('Hey there'));
    bot.command('hey', (ctx) => ctx.reply('I am a telegram bot'))
    bot.command('binarySearch', (ctx) => ctx.reply(binarySearch))
    bot.command('readme', async (ctx) => {
        const response = await axios.get("https://raw.githubusercontent.com/GedelaSivakrishna/Assignments/refs/heads/main/Frontend/employee-management-system/README.md");
        ctx.reply(response.data);
    })

    // bot.on(message("text"), ctx => ctx.reply("Hello"));
    bot.launch();
} catch(error) {
    console.log(error);
}
