using Microsoft.EntityFrameworkCore;
using NetService.Model;

namespace NetService
{
    public class ProductContext : DbContext
    {
        public DbSet<Product> Products { get; set; } = null;

        public ProductContext(DbContextOptions<ProductContext> options) : base(options)
        {
        }
    }
}
