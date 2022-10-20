document.querySelector("#graph").addEventListener("click", function (event) {
    const x = event.offsetX - 175;
    const y = -event.offsetY + 175;
    receiveFromGraph(x, y);
});

$(document).ready(function () {
    drawGraph();
})
const canvas = document.getElementById('graph')
const ctx = canvas.getContext('2d')
const width = canvas.width
const height = canvas.height
const markWidth = 5
const arrowSize = 5
const rSize = 60
const figureColor = '#39f'

function drawGraph() {
    drawFigure()
    drawPane()
}

function drawPane() {
    ctx.beginPath()
    ctx.moveTo(width / 2, height / 2)
    ctx.lineTo(width, height / 2)
    ctx.moveTo(width / 2, height / 2)
    ctx.lineTo(0, height / 2)
    ctx.moveTo(width / 2, height / 2)
    ctx.lineTo(width / 2, height)
    ctx.moveTo(width / 2, height / 2)
    ctx.lineTo(width / 2, 0)
    ctx.moveTo(width / 2 + rSize, height / 2 + markWidth)
    ctx.lineTo(width / 2 + rSize, height / 2 - markWidth)
    ctx.moveTo(width / 2 + rSize * 2, height / 2 + markWidth)
    ctx.lineTo(width / 2 + rSize * 2, height / 2 - markWidth)
    ctx.moveTo(width / 2 - rSize, height / 2 + markWidth)
    ctx.lineTo(width / 2 - rSize, height / 2 - markWidth)
    ctx.moveTo(width / 2 - rSize * 2, height / 2 + markWidth)
    ctx.lineTo(width / 2 - rSize * 2, height / 2 - markWidth)
    ctx.moveTo(width / 2 + markWidth, height / 2 + rSize)
    ctx.lineTo(width / 2 - markWidth, height / 2 + rSize)
    ctx.moveTo(width / 2 + markWidth, height / 2 + rSize * 2)
    ctx.lineTo(width / 2 - markWidth, height / 2 + rSize * 2)
    ctx.moveTo(width / 2 + markWidth, height / 2 - rSize)
    ctx.lineTo(width / 2 - markWidth, height / 2 - rSize)
    ctx.moveTo(width / 2 + markWidth, height / 2 - rSize * 2)
    ctx.lineTo(width / 2 - markWidth, height / 2 - rSize * 2)
    ctx.moveTo(width / 2, 0)
    ctx.lineTo(width / 2 + arrowSize, arrowSize)
    ctx.moveTo(width / 2, 0)
    ctx.lineTo(width / 2 - arrowSize, arrowSize)
    ctx.moveTo(width, height / 2)
    ctx.lineTo(width - arrowSize, height / 2 + arrowSize)
    ctx.moveTo(width, height / 2)
    ctx.lineTo(width - arrowSize, height / 2 - arrowSize)
    ctx.moveTo(width / 2, height / 2)
    ctx.font = '20px monospace'
    ctx.fillStyle = '#000'
    ctx.textAlign = 'center';
    ctx.fillText('-R/2', width / 2 - rSize, height * 8 / 17)
    ctx.fillText('-R', width / 2 - rSize * 2, height * 8 / 17)
    ctx.fillText('R/2', width / 2 + rSize, height * 8 / 17)
    ctx.fillText('R', width / 2 + rSize * 2, height * 8 / 17)
    ctx.textAlign = 'left'
    ctx.textBaseline = 'middle'
    ctx.fillText('-R/2', width * 9 / 17, width / 2 + rSize)
    ctx.fillText('-R', width * 9 / 17, width / 2 + rSize * 2)
    ctx.fillText('R/2', width * 9 / 17, width / 2 - rSize)
    ctx.fillText('R', width * 9 / 17, width / 2 - rSize * 2)
    ctx.font = '15px monospace'
    ctx.fillText('y', width * 9 / 17, arrowSize * 2)
    ctx.textAlign = 'center'
    ctx.textBaseline = 'bottom'
    ctx.fillText('x', width - arrowSize, height * 8 / 17)
    ctx.stroke()
    ctx.textAlign = 'center';
    ctx.font = '20px monospace'
    ctx.fillStyle = '#000'
}


function drawFigure() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.font = '20px monospace'
    ctx.fillStyle = '#000'
    ctx.textAlign = 'center'
    ctx.textBaseline = 'middle'
    ctx.beginPath()
    ctx.fillStyle = figureColor
    ctx.moveTo(width /2, height / 2);
    ctx.lineTo(width /2 - rSize, height / 2);
    ctx.lineTo(width / 2, height /2 + rSize * 2);
    ctx.lineTo(width /2 + rSize, height/2 + rSize * 2);
    ctx.lineTo(width/2 + rSize, height / 2);
    ctx.lineTo(width / 2, height /2);
    ctx.fill();
    ctx.moveTo(width / 2 + rSize * 2, height /2 );
    ctx.lineTo(width / 2, height / 2);
    ctx.lineTo(width /2, height / 2 - rSize * 2);
    ctx.arc(width / 2, height / 2, rSize * 2, Math.PI * 3 / 2, 0);
    ctx.fill();
}

function drawDot(x, y, r) {
    const realR = 3;
    const realX = ((x / (r * 1.4583)) * 175) + 175;
    const realY = -(((y * 175) / (r * 1.4583)) - 175);
    ctx.beginPath();
    ctx.moveTo(realX, realY);
    ctx.arc(realX, realY, realR, 0, Math.PI * 2);
    ctx.fillStyle = '#7CFC00';
    ctx.fill();
}


