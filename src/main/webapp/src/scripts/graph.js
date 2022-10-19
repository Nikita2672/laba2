document.querySelector(".element").addEventListener("click", function (event) {
    const x = event.offsetX - 150;
    const y = -event.offsetY + 150;
    // const canvas = $('.element');
    // if (canvas.getContext()) {
    //     const ctx = canvas.getContext('2d');
    //     ctx.fillStyle = '#00ffff';
    //     ctx.beginPath();
    //     ctx.arc(event.offsetX, event.offsetY, 3, 0, Math.PI * 2);
    //     ctx.fill();
    // }
    receiveFromGraph(x, y);
});
