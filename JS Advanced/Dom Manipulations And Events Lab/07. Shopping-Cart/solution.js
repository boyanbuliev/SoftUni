function solve() {
   const cart = [];
   const output = document.querySelector('textarea');
   document.querySelector('.shopping-cart').addEventListener('click', (ev) => {
      if (ev.target.tagName == 'BUTTON' && ev.target.className == 'add-product') {
         ev.target.parentNode.parentNode.querySelector('.product-line-price').textContent;
         const product = ev.target.parentNode.parentNode;
         const name = product.querySelector('.product-title').textContent;
         const price = Number(product.querySelector('.product-line-price').textContent);
         cart.push({ name, price });
         output.value += `Added ${name} for ${price.toFixed(2)} to the cart.\n`
      }
   });
   document.querySelector('.checkout').addEventListener('click', () => {
      const result = cart.reduce((acc, c) => {
         acc.items.add(c.name);
         acc.total += c.price;
         return acc;
      }, { items: new Set(), total: 0 });
      output.value += `You bought ${[...result.items].join(', ')} for ${result.total.toFixed(2)}.`;
      document.querySelectorAll('button').forEach(b => b.disabled = true);
   })
}